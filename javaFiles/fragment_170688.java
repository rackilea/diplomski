public void onClick(View v) {
    switch (v.getId()) {
        case R.id.button_1:
            map.put(pagePosition, 1);
            break;
        case R.id.button_2:
            map.put(pagePosition, 2);
            break;
    }

}