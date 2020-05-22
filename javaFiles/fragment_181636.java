package com.test.platos_4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class Adaptador2  extends RecyclerView.Adapter<Adaptador2.ViewHolder>
{
private List<Entidad2> listItems;
private OnRecipeListener mOnRecipeListener;

public  Adaptador2(List<Entidad2> listItems, OnRecipeListener onRecipeListener) {
    this.listItems = listItems;
    this.mOnRecipeListener = onRecipeListener;
}


@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista2, parent, false);
    return new ViewHolder(view, mOnRecipeListener);
}

@Override
public void onBindViewHolder(ViewHolder viewholder, int position) {
    Entidad2 entidad = listItems.get(position);
    int resource = entidad.getImgFoto();
    String title = entidad.getTitulo();
    String time = entidad.getTiempo();
    int barra = entidad.getRating();
    final int priority = entidad.getPriority();
    //int fondo = listItems.get(position).getColorfondo();
    viewholder.setData(resource, title, time, barra);

//You can pass the clicked item's priority back to your activity like this
    viewholder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    mOnRecipeListener.OnRecipe(priority);
        }
    });
    // por si necesito color de fondo viewholder.setData(resource, title, time, barra, fondo);
}

@Override
public int getItemCount() {
    return listItems.size();
}
class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imgFoto;
    private TextView titulo;
    private TextView tiempo;
    private RatingBar ratingBar;
    //private ImageView colorfondo;
    OnRecipeListener onRecipeListener;

    public ViewHolder(View itemView, OnRecipeListener onRecipeListener) {
        super(itemView);

        imgFoto = itemView.findViewById(R.id.imgFoto);
        titulo = itemView.findViewById(R.id.tvTitulo);
        tiempo = itemView.findViewById(R.id.tvTiempo);
        ratingBar = itemView.findViewById(R.id.ratingBarVerd);
        //colorfondo = itemView.findViewById(R.id.colorfondo);

        //This is useless
        //this.onRecipeListener = onRecipeListener;

    }

    //por si necesito color de fondo private void setData(int resource, String title, String time, int barra, int fondo){
    private void setData(int resource, String title, String time, int barra){
        imgFoto.setImageResource(resource);
        titulo.setText(title);
        tiempo.setText(time);
        ratingBar.setRating(barra);
        //colorfondo.setImageResource(fondo);

    }

    @Override
    public void onClick(View v) {

    }
}

public interface OnRecipeListener{
    void OnRecipe(int priority);
}
}