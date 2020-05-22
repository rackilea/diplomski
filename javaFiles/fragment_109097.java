package com.app.practiceapp;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] namesArray1 = new String[]{"Cupcake", "Donut", "Eclair", "Froyo"};

    Model model1 = new Model();
    model1.setNamesArray(namesArray1);

    String[] namesArray2 = new String[]{"Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean"};
    Model model2 = new Model();
    model2.setNamesArray(namesArray2);

    String[] namesArray3 = new String[]{"Kitkat", "Lollipop", "Marshmallow", "Nougat"};
    Model model3 = new Model();
    model3.setNamesArray(namesArray3);

    String[] namesArray4 = new String[]{"Prashant", "Android", "Developer"};
    Model model4 = new Model();
    model4.setNamesArray(namesArray4);

    ArrayList<Model> modelList = new ArrayList<>();

    modelList.add(model1);
    modelList.add(model2);
    modelList.add(model3);
    modelList.add(model4);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    recyclerView.setAdapter(new MyAdapter(modelList));

}


class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> modelList;

    MyAdapter(ArrayList<Model> myList) {

        this.modelList = myList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_recyclerview, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        for (int i = 0; i < modelList.get(position).getNamesArray().length; i++) {

            TextView textView = new TextView(MainActivity.this);
            textView.setGravity(Gravity.CENTER);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 10, 10, 10);
            textView.setLayoutParams(layoutParams);

            textView.setPadding(10, 10, 10, 10);
            textView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_blue_light));

            textView.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
            textView.setText(modelList.get(position).namesArray[i]);

            holder.itemContainerLayout.addView(textView);

        }


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout itemContainerLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemContainerLayout = (LinearLayout) itemView.findViewById(R.id.containerLayout);
        }
    }
}

class Model {

    private String[] namesArray;

    public void setNamesArray(String[] namesArray) {
        this.namesArray = namesArray;
    }

    public String[] getNamesArray() {

        return namesArray;
    }


}
}