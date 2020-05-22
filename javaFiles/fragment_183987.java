import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;   
import com.bumptech.glide.Glide;    
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private AsyncListDiffer<User> mAsyncListDiffer;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView singleItemTextView;
        public ImageView singleItemImage;
        public View layout;
        public ConstraintLayout constraintLayout;

        public MyViewHolder(View v) {
            super(v);
            layout = v;
            singleItemImage = (ImageView) v.findViewById(R.id.icon);
            singleItemTextView = (TextView) v.findViewById(R.id.singleitemtv);
            constraintLayout = (ConstraintLayout) v.findViewById(R.id.nbConstraintLayout);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter() {
        DiffUtil.ItemCallback<User> diffUtilCallback = new DiffUtil.ItemCallback<User>() {

            @Override
            public boolean areItemsTheSame(@NonNull User newUser, @NonNull User oldUser) {
                return newUser.getUserId().equals(oldUser.getUserId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull User newUser, @NonNull User oldUser) {
                return newUser.equals(oldUser);
            }
        };
        mAsyncListDiffer = new AsyncListDiffer<>(this, diffUtilCallback);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nb_image_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        User user = mAsyncListDiffer.getCurrentList().get(position);
        Uri userImage = user.getImageUrl();
        holder.singleItemTextView.setText(user.getUserId());

        Glide.with(holder.itemView.getContext() /* context */)
                .load(userImage)
                .into(holder.singleItemImage);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(v.getContext(), DisplayUserActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAsyncListDiffer.getCurrentList().size();
    }

    public void updateList(List<User> newList) {
        mAsyncListDiffer.submitList(newList);
    }

}