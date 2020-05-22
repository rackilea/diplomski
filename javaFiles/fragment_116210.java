import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class RecyclerAdapter extends 
RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

Context context;
int LayoutId;
List<ItemModel> data;


public RecyclerAdapter(Context context, int layoutId, List<ItemModel> data) {
    this.context = context;
    LayoutId = layoutId;
    this.data = data;
}

@NonNull
@Override
public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int 
viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View myView = inflater.inflate(LayoutId,null);
    return new RecyclerViewHolder(myView);
}

@Override
public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int 
position) {
    final ItemModel singleItem = data.get(position);
    holder.imgTitle.setText(singleItem.getImgTitle());
    holder.img.setImageDrawable(context.getResources()
   .getDrawable(singleItem.getImgId()));

   //checking which layout is in layoutId and adding onclick listener
    if (LayoutId == R.layout.item_layout_horizontal)
    {
        holder.horizontalLayout.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) {
                //check which item is clicked here and proceed
                if(position==0)
                {
                    //do something
                }
                else if(position==1)
                {
                     //do something
                }
                else if(position==2)
                {
                    //do something
                }
                //and so on to the list end

            }
        });
    }

    else {
        holder.verticalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check which item is clicked here and proceed
                if(position==0)
                {
                    //do something
                }
                else if(position==1)
                {
                    //do something
                }
                else if(position==2)
                {
                    //do something
                }
                //and so on to the list end

            }
        });
    }

    }

@Override
public int getItemCount() {
    return data.size();
}

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    TextView imgTitle;
    ImageView img;
    LinearLayout horizontalLayout,verticalLayout;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imgTitle = itemView.findViewById(R.id.imgTitle);
        img = itemView.findViewById(R.id.img);
        //fetching the container views that are to be attached to the 
        //recycler view and for adding onclick listeners 
        //(because of multiple layouts for the same adapter)
        if(LayoutId==R.layout.item_layout_horizontal)

            horizontalLayout=itemView.findViewById(R.id.horizontalContainer);
        else

            verticalLayout=itemView.findViewById(R.id.verticalContainer);

        }

        } 
}