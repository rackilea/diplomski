package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MaterialCardView cPublic, cFriends, cPrivate;
    public FrameLayout sPublic, sFriends, sPrivate;
    public ArrayList<MaterialCardView> cards;
    public ArrayList<FrameLayout> strokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new ArrayList<>();
        strokes = new ArrayList<>();

        cPublic = findViewById(R.id.public_card);
        cFriends = findViewById(R.id.friends_card);
        cPrivate = findViewById(R.id.private_card);

        cards.add(cPublic);
        cards.add(cFriends);
        cards.add(cPrivate);

        sPublic = findViewById(R.id.public_stroke);
        sFriends = findViewById(R.id.friends_stroke);
        sPrivate = findViewById(R.id.private_stroke);

        strokes.add(sPublic);
        strokes.add(sFriends);
        strokes.add(sPrivate);

        cPublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChecked(cPublic);
            }
        });

        cFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChecked(cFriends);
            }
        });

        cPrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChecked(cPrivate);
            }
        });

    }

    public void setChecked(MaterialCardView selected) {

        int index = cards.indexOf(selected);
        FrameLayout stroke = strokes.get(index);

        stroke.setVisibility(View.VISIBLE);

        for (FrameLayout s : strokes) {
            if (!s.equals(stroke)) {
                s.setVisibility(View.INVISIBLE);
            }
        }

    }

    public MaterialCardView checkedCard() {
        int index = 0;
        for (FrameLayout s : strokes) {
            if (s.getVisibility() == View.VISIBLE) {
                index = strokes.indexOf(s);
            }
        }
        return cards.get(index);
    }
}