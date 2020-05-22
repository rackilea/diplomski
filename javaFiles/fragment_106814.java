public class Comida extends AppCompatActivity implements Adaptador.OnRecipeListener {
private RecyclerView recyclerView1;
List<Entidad> listItems;
Adaptador adaptor;
private Entidad entidad1,entidad2,entidad3;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_comida);

    recyclerView1 = findViewById(R.id.lv_1);
    LinearLayoutManager layoutManager = new 
    LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    recyclerView1.setLayoutManager(layoutManager);

    listItems = new ArrayList<>();
//Initialize entidad objects and keep references of them to use in pickEntidad() method

   entidad1 = new Entidad(R.drawable.calabacines_3, "Solomillo a la plancha", " 10 min.", 4, R.drawable.color_carnes,50);
   entidad2 = new Entidad(R.drawable.patatas_deluxe_especiadas_70523_300_150, "Entrecot", " 15 min.", 2, R.drawable.color_carnes,200);
    entidad3 = new Entidad(R.drawable.tomate, "Hamburguesa", " 2 min.", 5, R.drawable.color_carnes,350);

    listItems.add(entidad1);
    listItems.add(entidad2); 
    listItems.add(entidad3);

    adaptor = new Adaptador(listItems, this);
    recyclerView1.setAdapter(adaptador);
    adaptor.notifyDataSetChanged();
//Call pickEntidad() to randomly pick one entidad and show on the list
    pickEntidad();
}

@Override
public void OnRecipe(int position) {

    if (position == 0) {
        Intent in = new Intent(this, Solomillo.class);
        startActivity(in);
    }
}
private void pickEntidad(){
//Generates random int value between 0-350
final int random = new Random().nextInt(351);

//get priorities from your created Entidad objects.
int priority1 = entidad1.getPriority();
int priority2 = entidad2.getPriority();
int priority3 = entidad3.getPriority();


listItems.clear()

//Pick one randomly depending on priority
if(random < priority1){

listItems.add(entidad1)

}else if(random < priority2){

listItems.add(entidad2)

}else if (random <= priority3){

listItems.add(entidad3)

}

//update your adapter

adaptor.notifyDataSetChanged()
}
}