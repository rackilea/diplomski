import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

RecyclerView topRecyclerView, bottomRecyclerView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_main);
    // Fetching View From XMl
    topRecyclerView = findViewById(R.id.topRecyclerView);
    bottomRecyclerView = findViewById(R.id.bottomRecyclerView);

    // Data For Top Recycler Views
    List<ItemModel> topRecycleData = new ArrayList<ItemModel>();
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 1"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 2"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 3"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 4"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 5"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 6"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 7"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 8"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 9"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 10"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 11"));
    topRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 12"));


    // Data For Bottom Recycler Views
    List<ItemModel> bottomRecycleData = new ArrayList<ItemModel>();
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 1"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 2"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 3"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 4"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 5"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 6"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 7"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 8"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 9"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 10"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 11"));
    bottomRecycleData.add(new ItemModel(R.mipmap.ic_launcher,"Img 12"));

    // Setting Layouts To Recycler Views
    topRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    bottomRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    // Creating Adapters (No need to send onNote)
    RecyclerAdapter topAdapter = new RecyclerAdapter
    (this,R.layout.item_layout_vertical,topRecycleData);
    RecyclerAdapter bottomAdapter = new RecyclerAdapter
    (this,R.layout.item_layout_horizontal,bottomRecycleData);

    // Setting Adapters To Layouts
    topRecyclerView.setAdapter(topAdapter);
    bottomRecyclerView.setAdapter(bottomAdapter);
}
}