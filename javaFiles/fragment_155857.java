@Override
public void onItemClick(View view, int position) {
    // Imagen a compartir entre transiciones
    View sharedImage = view.findViewById(R.id.imagenp);
    Intent intent = new Intent(context, DetailedActivty.class)
    intent.putExtra(nombrep, NOMBREP_EXTRA);
    intent.putExtra(descripcionp, DESCRIPCIONP_EXTRA);
    intent.putExtra(franquiciap, FRANQUICIAP_EXTRA);
    context.startActivity(intent);
}