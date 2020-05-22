switch (v.getId())
    {
        case R.id.button1:
            Intent i1 = new Intent(getActivity(), GameActivity.class);
            i1.putExtra("s", 10);
            startActivity(i1);
            break;
        case R.id.button2:
            Intent i2 = new Intent(getActivity(), GameActivity.class);
            i2.putExtra("s", 30);
            startActivity(i2);
            break;
        case R.id.button3:
            Intent i3 = new Intent(getActivity(), GameActivity.class);
            i3.putExtra("s", 50);
            startActivity(i3);
            break;
    }