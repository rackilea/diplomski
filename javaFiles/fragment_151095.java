adap = new SimpleCursorAdapter(
    getBaseContext(),
    R.layout.lv_layout,
    null,
    new String[]{"name", "number", "photo"},
    new int[]{R.id.tv_name, R.id.tv_number, R.id.iv_photo},
    0
);