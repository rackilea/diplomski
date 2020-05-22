package com.example.mynotes;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

public class SyncEditText extends AppCompatEditText implements TextWatcher {
    private SyncEditText[] mDependencies;
    private boolean shouldSync = true;

    public SyncEditText(Context context) {
        super(context);
    }

    public SyncEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SyncEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // This is to avoid text changed event is called multiple time per character because auto suggestion
        setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        addTextChangedListener(this);
    }

    private void addTextChangedListener(SyncEditText syncEditText) {
    }

    public void setDependencies(SyncEditText... dependencies) {
        mDependencies = dependencies;
    }

    public void setText(CharSequence text, boolean syncDependencies) {
        shouldSync = syncDependencies;
        setText(text);

        Log.d("Log", "Text sync: " + text);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

    @Override
    public void afterTextChanged(Editable editable) { }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (mDependencies == null)
            return;

        if (!shouldSync) {
            // If this text is sync from other SyncEditText, ignore the change
            shouldSync = true;
            return;
        }

        Log.d("Log", "Text input: " + charSequence);

        // Sync to all dependencies
        for (SyncEditText syncEditText : mDependencies) {
            syncEditText.setText(charSequence, false);
        }
    }
}