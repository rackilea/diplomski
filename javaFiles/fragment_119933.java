float distanceX = e2.getX() - e1.getX();
        float distanceY = e2.getY() - e1.getY();
        int id = list.pointToPosition((int) e1.getX(), (int) e1.getY());

        String text=adapter.getItem(id);
        Toast.makeText(context,"Text:"+text,Toast.LENGTH_SHORT).show();