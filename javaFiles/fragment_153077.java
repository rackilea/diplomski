switch (position){
    case 1:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new Sar()).commit();
        break;
    case 2:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new Pagdi()).commit();
        break;
}