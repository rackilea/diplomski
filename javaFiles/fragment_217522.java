public class BoxAdapter extends BaseAdapter {
Context ctx;
LayoutInflater lInflater;
ArrayList<Product> objects;
ArrayList<boolean> userSelected; // Here i added a ArrayList of booleans to remember the user chooise
String title;
public ImageView iv;
public int counter;
public ArrayList<ImgArray> iarr = new ArrayList<ImgArray>();
public ArrayList<ImgArray> startIarr = new ArrayList<ImgArray>();
final String LOG_TAG = "myLogs";


BoxAdapter(Context context, ArrayList<Product> products, String curTitle) {
    ctx = context;
    objects = products;
    lInflater = (LayoutInflater) ctx
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    //Получаю название Activity
    title = curTitle;
}

// кол-во элементов
@Override
public int getCount() {
    return objects.size();
}

// элемент по позиции
@Override
public Object getItem(int position) {
    return objects.get(position);
}

// id по позиции
@Override
public long getItemId(int position) {
    return position;
}

// пункт списка
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
    final boolean selected = userSelected.get(position);

    // заполняем View в пункте списка данными из класса продукт: наименование, картинка и тег(используется для детекта картинки)
    // и картинка
    ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
    ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);
    ((ImageView) view.findViewById(R.id.ivImage)).setTag(p.tag);

    iv = ((ImageView) view.findViewById(R.id.ivImage));

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
            userSelected.set(position, !selected);
            if (!selected) {
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


// товар по позиции
Product getProduct(int position) {
    return ((Product) getItem(position));
}


//Функция для возврата информации о количестве элементов в массиве картинок(не используется)
public Object getV (View v,int position) {
    ListView lv = (ListView) v.findViewById(R.id.lvView);

    //Object o = lv.getItemAtPosition(position);
    Object o = iarr.size();

    return o;
}


//Функция для возврата элемента картинок
public ArrayList iFunc(){
    return iarr;
}

//не используется
public ArrayList sIarr(){
    return startIarr;
}

//не используется
public int C (View v) {
    ListView lv = (ListView) v.findViewById(R.id.lvView);
    return lv.getCount();
}



}