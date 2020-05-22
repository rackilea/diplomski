switch( valFoulsHome ) {
    case 5:
        btnFoulsHome.setImageResource(R.drawable.fouls5);
        break;
    case 4:
        btnFoulsHome.setImageResource(R.drawable.fouls4);
        break;
    case 3:
        btnFoulsHome.setImageResource(R.drawable.fouls3);
        break;
    case 2:
        btnFoulsHome.setImageResource(R.drawable.fouls2);
        break;
    case 1:
        btnFoulsHome.setImageResource(R.drawable.fouls1);
        break;
    case 0:
    default: // You should always have a default case
        btnFoulsHome.setImageResource(R.drawable.fouls0);
}