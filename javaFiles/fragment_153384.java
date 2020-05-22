package com.test.rxjavaprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private Observable<Integer> observable;
    private Observer<Integer> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
           @Override

           public void subscribe(ObservableEmitter<Integer> e) throws Exception {
               // doInBackground
               for (int i=1; i<= 100; i++) {
                   Log.e(String.valueOf(Thread.currentThread().getId()), "i: " + i);
                   e.onNext(i);
                   Thread.sleep(50);
               }
               e.onComplete();
           }
       }
        );


        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                // onPreExecute
                Log.e(String.valueOf(Thread.currentThread().getId()), "onSubscribe: ");
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNext(Integer value) {
                // onProgressUpdate
                Log.e(String.valueOf(Thread.currentThread().getId()), "onNext: " + value);
                progressBar.setProgress(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(String.valueOf(Thread.currentThread().getId()), "onError: ");
            }

            @Override
            public void onComplete() {
                // onPostExecute
                Log.e(String.valueOf(Thread.currentThread().getId()), "onComplete: All Done!");
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
    }

    public void button(View view){
        Log.e(String.valueOf(Thread.currentThread().getId()), "button: Clicked");
        // Start background task
        observable.observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(observer);
    }
}