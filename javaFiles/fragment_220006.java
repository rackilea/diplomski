for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        Log.e(snap.getKey(), snap.getChildrenCount() + "");

                        if (snap.getChildrenCount() != 0) {

                            postId = "postId" + String.valueOf(snap.getChildrenCount() + 1);
                            SharedPreferencesUtils.setStringPreference(getActivity(), "postId", postId);

                        } else {
                            postId = "postId" + String.valueOf(1);
                            SharedPreferencesUtils.setStringPreference(getActivity(), "postId", postId);
                        }


                    }