class A extends AppCompatActivity {
private MyAdapter adapter = MyAdapter()
 ....
void passData(){
   OnChangeColor onChangeColor = adapter;
   onChangeColor.onColorChanged();
 }
}