package com.example.mynotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout Options;
    boolean optionVisible = false;
    LinearLayout Main;
    LinearLayout Main_with_opt;
    LayoutAnimationController show_lessAnimation;
    LayoutAnimationController show_moreAnimation;
    com.example.mynotes.SyncEditText Typer;
    com.example.mynotes.SyncEditText Typer_with_opt;
    int mSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main_with_opt = findViewById(R.id.main_with_opt);
        Options = findViewById(R.id.options);

        Main = findViewById(R.id.main);

        Typer = findViewById(R.id.typer);
        Typer_with_opt = findViewById(R.id.typer_with_opt);

        Typer.setDependencies(Typer_with_opt);
        Typer_with_opt.setDependencies(Typer);

        show_lessAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.show_less_layout);
        show_moreAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.show_more_layout);
    }

    public void show(View v) {
        if (optionVisible) {
            Main_with_opt.setLayoutAnimationListener(show_lessAnimationListener);
            Main_with_opt.setLayoutAnimation(show_lessAnimation);
            Typer.requestFocus();
            Typer.setSelection(Typer_with_opt.getSelectionStart());
            Typer.scrollTo(Typer_with_opt.getScrollX(), Typer_with_opt.getScrollY());
            Main_with_opt.startLayoutAnimation();
        } else {
            Main_with_opt.setLayoutAnimationListener(show_moreAnimationListener);
            Main_with_opt.setLayoutAnimation(show_moreAnimation);
            Main_with_opt.setVisibility(View.VISIBLE);
            Typer_with_opt.requestFocus();
            Typer_with_opt.setSelection(Typer.getSelectionStart());
            Typer_with_opt.scrollTo(Typer.getScrollX(), Typer.getScrollY());
            Main.setVisibility(View.GONE);
            Main_with_opt.startLayoutAnimation();
        }
        optionVisible = !optionVisible;
    }

    Animation.AnimationListener show_lessAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Main.setVisibility(View.VISIBLE);
            Main_with_opt.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    Animation.AnimationListener show_moreAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

}