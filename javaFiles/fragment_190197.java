/*
 * Copyright (c) 2016 Ben Randall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.your.package;

import android.accessibilityservice.AccessibilityService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;


/**
 * @author benrandall76 AT gmail DOT com
 */

public class MyAccessibilityService extends AccessibilityService {

    private final boolean DEBUG = true;
    private final String CLS_NAME = MyAccessibilityService.class.getSimpleName();

    private static final String GOOGLE_VOICE_SEARCH_PACKAGE_NAME = "com.google.android.googlequicksearchbox";
    private static final String GOOGLE_VOICE_SEARCH_INTERIM_FIELD = "com.google.android.apps.gsa.searchplate.widget.StreamingTextView";
    private static final String GOOGLE_VOICE_SEARCH_FINAL_FIELD = "com.google.android.apps.gsa.searchplate.SearchPlate";

    private static final long COMMAND_UPDATE_DELAY = 1000L;

    private long previousCommandTime;
    private String previousCommand = null;

    private final boolean EXTRA_VERBOSE = false;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        if (DEBUG) {
            Log.i(CLS_NAME, "onServiceConnected");
        }
    }

    @Override
    public void onAccessibilityEvent(final AccessibilityEvent event) {
        if (DEBUG) {
            Log.i(CLS_NAME, "onAccessibilityEvent");
        }

        if (event != null) {

            switch (event.getEventType()) {

                case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                    if (DEBUG) {
                        Log.i(CLS_NAME, "onAccessibilityEvent: checking for google");
                    }

                    if (event.getPackageName() != null && event.getPackageName().toString().matches(
                            GOOGLE_VOICE_SEARCH_PACKAGE_NAME)) {
                        if (DEBUG) {
                            Log.i(CLS_NAME, "onAccessibilityEvent: checking for google: true");
                            Log.i(CLS_NAME, "onAccessibilityEvent: event.getPackageName: " + event.getPackageName());
                            Log.i(CLS_NAME, "onAccessibilityEvent: event.getClassName: " + event.getClassName());
                        }

                        final AccessibilityNodeInfo source = event.getSource();

                        if (source != null && source.getClassName() != null) {

                            if (source.getClassName().toString().matches(
                                    GOOGLE_VOICE_SEARCH_INTERIM_FIELD)) {
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "onAccessibilityEvent: className interim: true");
                                    Log.i(CLS_NAME, "onAccessibilityEvent: source.getClassName: " + source.getClassName());
                                }

                                if (source.getText() != null) {

                                    final String text = source.getText().toString();
                                    if (DEBUG) {
                                        Log.i(CLS_NAME, "onAccessibilityEvent: interim text: " + text);
                                    }

                                    if (interimMatch(text)) {
                                        if (DEBUG) {
                                            Log.i(CLS_NAME, "onAccessibilityEvent: child: interim match: true");
                                        }

                                        if (commandDelaySufficient(event.getEventTime())) {
                                            if (DEBUG) {
                                                Log.i(CLS_NAME, "onAccessibilityEvent: commandDelaySufficient: true");
                                            }

                                            if (!commandPreviousMatches(text)) {
                                                if (DEBUG) {
                                                    Log.i(CLS_NAME, "onAccessibilityEvent: commandPreviousMatches: false");
                                                }

                                                previousCommandTime = event.getEventTime();
                                                previousCommand = text;

                                                killGoogle();

                                                if (DEBUG) {
                                                    Log.e(CLS_NAME, "onAccessibilityEvent: INTERIM PROCESSING: " + text);
                                                }

                                            } else {
                                                if (DEBUG) {
                                                    Log.i(CLS_NAME, "onAccessibilityEvent: commandPreviousMatches: true");
                                                }
                                            }
                                        } else {
                                            if (DEBUG) {
                                                Log.i(CLS_NAME, "onAccessibilityEvent: commandDelaySufficient: false");
                                            }
                                        }
                                        break;
                                    } else {
                                        if (DEBUG) {
                                            Log.i(CLS_NAME, "onAccessibilityEvent: child: interim match: false");
                                        }
                                    }
                                } else {
                                    if (DEBUG) {
                                        Log.i(CLS_NAME, "onAccessibilityEvent: interim text: null");
                                    }
                                }
                            } else if (source.getClassName().toString().matches(
                                    GOOGLE_VOICE_SEARCH_FINAL_FIELD)) {
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "onAccessibilityEvent: className final: true");
                                    Log.i(CLS_NAME, "onAccessibilityEvent: source.getClassName: " + source.getClassName());
                                }

                                final int childCount = source.getChildCount();
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "onAccessibilityEvent: childCount: " + childCount);
                                }

                                if (childCount > 0) {
                                    for (int i = 0; i < childCount; i++) {

                                        final String text = examineChild(source.getChild(i));

                                        if (text != null) {
                                            if (DEBUG) {
                                                Log.i(CLS_NAME, "onAccessibilityEvent: child text: " + text);
                                            }

                                            if (finalMatch(text)) {
                                                if (DEBUG) {
                                                    Log.i(CLS_NAME, "onAccessibilityEvent: child: final match: true");
                                                }

                                                if (commandDelaySufficient(event.getEventTime())) {
                                                    if (DEBUG) {
                                                        Log.i(CLS_NAME, "onAccessibilityEvent: commandDelaySufficient: true");
                                                    }

                                                    if (!commandPreviousMatches(text)) {
                                                        if (DEBUG) {
                                                            Log.i(CLS_NAME, "onAccessibilityEvent: commandPreviousMatches: false");
                                                        }

                                                        previousCommandTime = event.getEventTime();
                                                        previousCommand = text;

                                                        killGoogle();

                                                        if (DEBUG) {
                                                            Log.e(CLS_NAME, "onAccessibilityEvent: FINAL PROCESSING: " + text);
                                                        }

                                                    } else {
                                                        if (DEBUG) {
                                                            Log.i(CLS_NAME, "onAccessibilityEvent: commandPreviousMatches: true");
                                                        }
                                                    }
                                                } else {
                                                    if (DEBUG) {
                                                        Log.i(CLS_NAME, "onAccessibilityEvent: commandDelaySufficient: false");
                                                    }
                                                }
                                                break;
                                            } else {
                                                if (DEBUG) {
                                                    Log.i(CLS_NAME, "onAccessibilityEvent: child: final match: false");
                                                }
                                            }
                                        } else {
                                            if (DEBUG) {
                                                Log.i(CLS_NAME, "onAccessibilityEvent: child text: null");
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "onAccessibilityEvent: className: unwanted " + source.getClassName());
                                }

                                if (EXTRA_VERBOSE) {

                                    if (source.getText() != null) {

                                        final String text = source.getText().toString();
                                        if (DEBUG) {
                                            Log.i(CLS_NAME, "onAccessibilityEvent: unwanted text: " + text);
                                        }
                                    } else {
                                        if (DEBUG) {
                                            Log.i(CLS_NAME, "onAccessibilityEvent: unwanted text: null");
                                        }
                                    }

                                    final int childCount = source.getChildCount();
                                    if (DEBUG) {
                                        Log.i(CLS_NAME, "onAccessibilityEvent: unwanted childCount: " + childCount);
                                    }

                                    if (childCount > 0) {

                                        for (int i = 0; i < childCount; i++) {

                                            final String text = examineChild(source.getChild(i));

                                            if (text != null) {
                                                if (DEBUG) {
                                                    Log.i(CLS_NAME, "onAccessibilityEvent: unwanted child text: " + text);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (DEBUG) {
                                Log.i(CLS_NAME, "onAccessibilityEvent: source null");
                            }
                        }
                    } else {
                        if (DEBUG) {
                            Log.i(CLS_NAME, "onAccessibilityEvent: checking for google: false");
                        }
                    }
                    break;
                default:
                    if (DEBUG) {
                        Log.i(CLS_NAME, "onAccessibilityEvent: not interested in type");
                    }
                    break;
            }
        } else {
            if (DEBUG) {
                Log.i(CLS_NAME, "onAccessibilityEvent: event null");
            }
        }
    }

    /**
     * Check if the previous command was actioned within the {@link #COMMAND_UPDATE_DELAY}
     *
     * @param currentTime the time of the current {@link AccessibilityEvent}
     * @return true if the delay is sufficient to proceed, false otherwise
     */
    private boolean commandDelaySufficient(final long currentTime) {
        if (DEBUG) {
            Log.i(CLS_NAME, "commandDelaySufficient");
        }

        final long delay = (currentTime - COMMAND_UPDATE_DELAY);

        if (DEBUG) {
            Log.i(CLS_NAME, "commandDelaySufficient: delay: " + delay);
            Log.i(CLS_NAME, "commandDelaySufficient: previousCommandTime: " + previousCommandTime);
        }

        return delay > previousCommandTime;
    }

    /**
     * Check if the previous command/text matches the current text we are considering processing
     *
     * @param text the current text
     * @return true if the text matches the previous text we processed, false otherwise.
     */
    private boolean commandPreviousMatches(@NonNull final String text) {
        if (DEBUG) {
            Log.i(CLS_NAME, "commandPreviousMatches");
        }

        return previousCommand != null && previousCommand.matches(text);
    }

    /**
     * Check if the interim text matches a command we want to intercept
     *
     * @param text the intercepted text
     * @return true if the text matches a command false otherwise
     */
    private boolean interimMatch(@NonNull final String text) {
        if (DEBUG) {
            Log.i(CLS_NAME, "interimMatch");
        }
        return text.matches("do interim results work");
    }

    /**
     * Check if the final text matches a command we want to intercept
     *
     * @param text the intercepted text
     * @return true if the text matches a command false otherwise
     */
    private boolean finalMatch(@NonNull final String text) {
        if (DEBUG) {
            Log.i(CLS_NAME, "finalMatch");
        }

        return text.matches("do final results work");
    }

    /**
     * Recursively examine the {@link AccessibilityNodeInfo} object
     *
     * @param parent the {@link AccessibilityNodeInfo} parent object
     * @return the extracted text or null if no text was contained in the child objects
     */
    private String examineChild(@Nullable final AccessibilityNodeInfo parent) {
        if (DEBUG) {
            Log.i(CLS_NAME, "examineChild");
        }

        if (parent != null) {

            for (int i = 0; i < parent.getChildCount(); i++) {

                final AccessibilityNodeInfo nodeInfo = parent.getChild(i);

                if (nodeInfo != null) {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "examineChild: nodeInfo: getClassName: " + nodeInfo.getClassName());
                    }

                    if (nodeInfo.getText() != null) {
                        if (DEBUG) {
                            Log.i(CLS_NAME, "examineChild: have text: returning: " + nodeInfo.getText().toString());
                        }
                        return nodeInfo.getText().toString();
                    } else {
                        if (DEBUG) {
                            Log.i(CLS_NAME, "examineChild: text: null: recurse");
                        }

                        final int childCount = nodeInfo.getChildCount();
                        if (DEBUG) {
                            Log.i(CLS_NAME, "examineChild: childCount: " + childCount);
                        }

                        if (childCount > 0) {

                            final String text = examineChild(nodeInfo);

                            if (text != null) {
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "examineChild: have recursive text: returning: " + text);
                                }
                                return text;
                            } else {
                                if (DEBUG) {
                                    Log.i(CLS_NAME, "examineChild: recursive text: null");
                                }
                            }
                        }
                    }
                } else {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "examineChild: nodeInfo null");
                    }
                }
            }
        } else {
            if (DEBUG) {
                Log.i(CLS_NAME, "examineChild: parent null");
            }
        }

        return null;
    }

    /**
     * Kill or reset Google
     */
    private void killGoogle() {
        if (DEBUG) {
            Log.i(CLS_NAME, "killGoogle");
        }

        // TODO - Either kill the Google process or send an empty intent to clear current search process
    }

    @Override
    public void onInterrupt() {
        if (DEBUG) {
            Log.i(CLS_NAME, "onInterrupt");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            Log.i(CLS_NAME, "onDestroy");
        }
    }
}