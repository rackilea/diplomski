@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // используем созданные, но не используемые view
    View view = convertView;
    if (view == null) {
        view = lInflater.inflate(R.layout.item, parent, false);
    }

    Product p = getProduct(position);
    final int pos = position;
    final String name = p.name;
    final boolean selected = p.userSelectedIt;

    // заполняем View в пункте списка данными из класса продукт: наименование, картинка и тег(используется для детекта картинки)
    // и картинка
    ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
    ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);
    ((ImageView) view.findViewById(R.id.ivImage)).setTag(p.tag);

    iv = ((ImageView) view.findViewById(R.id.ivImage));

    String temp = (String)iv.getTag();      //Получаю инфу, какая картинка у текущего элемента

    //Блок для определения какую картинку добавить в массив
    if (selected)
        iarr.add(new ImgArray(iv,pos,name,"yes"));
    else
        iarr.add(new ImgArray(iv,pos,name,"no"));

    //Обработчик нажатия на картинку

    iv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // Здесь можно писать в базу, в name содержится имя продукта по которому кликнули
            //
            // Log.d(LOG_TAG,"PRODUCT --- " + name);
            Log.d(LOG_TAG, "NAME ACTIVITY --- " + title);

            //Получаю картинку, которая была нажата
            LinearLayout ll = (LinearLayout) view.getParent();
            ImageView iv = (ImageView) ll.getChildAt(0);

            //String bufferTag = (String) iv.getTag();        //Получаю данные, какая картинка была перед нажатием

            //Блок для определения, какая картинка пришла и на какую ее изменить
            selected = !selected;
            if (selected) {
                iv.setImageResource(R.drawable.no);
                iarr.set(pos,new ImgArray(iv,pos,name,"no"));       //Заменяется картинка в массиве картинок. Замена происходит по позиции

            }
            else {
                iv.setImageResource(R.drawable.yes);
                iarr.set(pos,new ImgArray(iv,pos,name,"yes"));
            }
        }
    });

    return view;
}