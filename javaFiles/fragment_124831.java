package com.example.stackoflow_alertdialog;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SOF_AlertDialog extends Activity 
{
    ArrayList<ItemDetail> image_detail;
    private int[] images={R.drawable.ball1,R.drawable.ball2,R.drawable.ball5};
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sof__alert_dialog);

        image_detail = GetSearchResult();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter());

        lv1.setOnItemClickListener(new OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> a, View view, int position, long id)
            {
                AlertDialog.Builder mAlert = new AlertDialog.Builder(SOF_AlertDialog.this);

                view = getLayoutInflater().inflate(R.layout.alert_background,null);

                ImageView Content_img = (ImageView)view.findViewById(R.id.imageView1);
                TextView Content_txt1 = (TextView)view.findViewById(R.id.textView1);
                TextView Content_txt2 = (TextView)view.findViewById(R.id.textView2);
                TextView Content_txt3 = (TextView)view.findViewById(R.id.textView3);
                Content_img.setImageResource(image_detail.get(position).getImageNumber());
                Content_txt1.setText(image_detail.get(position).getName());
                Content_txt2.setText(image_detail.get(position).getItemDescription());
                Content_txt3.setText("Price: "+image_detail.get(position).getPrice());

//              mAlert.setIcon(image_detail.get(position).getImageNumber()).
                mAlert.setTitle(image_detail.get(position).getName()).
                setView(view).
//              setMessage(image_detail.get(position).getItemDescription()+"\nPrice: "+image_detail.get(position).getPrice()).
                setPositiveButton("Buy", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                }).
                setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                }).create().show();
            }
         });
       }

    private ArrayList<ItemDetail> GetSearchResult() 
    {
        // TODO Auto-generated method stub
        ArrayList<ItemDetail> result = new ArrayList<ItemDetail>();

        //Beri keterangan untuk arrayitem detail
        ItemDetail item_detail = new ItemDetail();
        item_detail.setName("Cake");
        item_detail.setItemDescription("");
        item_detail.setPrice("5.000");
        item_detail.setImageNumber(images[0]);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setName("Coklat");
        item_detail.setItemDescription("Bulat");
        item_detail.setPrice("5.500");
        item_detail.setImageNumber(images[1]);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setName("Purple");
        item_detail.setItemDescription("Cupcake");
        item_detail.setPrice("6.000");
        item_detail.setImageNumber(images[2]);
        result.add(item_detail);

        return result;
    }

    private class ItemListBaseAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return image_detail.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                convertView = getLayoutInflater().inflate(R.layout.custom_row, parent, false);
                TextView txtName = (TextView)convertView.findViewById(R.id.textView1);
                TextView txtDescription = (TextView)convertView.findViewById(R.id.textView2);
                TextView txtPrice = (TextView)convertView.findViewById(R.id.textView3);
                ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);

                txtName.setText(image_detail.get(position).getName());
                txtDescription.setText(image_detail.get(position).getItemDescription());
                txtPrice.setText(image_detail.get(position).getPrice());
                img.setImageResource(image_detail.get(position).getImageNumber());

            return convertView;
        }

    }
}