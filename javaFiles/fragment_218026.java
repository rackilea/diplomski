package com.android.myfragmentstodo;




        import android.app.Fragment;
        import android.os.Bundle;


        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;

/**
 * Created by Malan on 4/20/2015.
 */
public class PM_Fragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    View rootView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState){

        rootView = inflater.inflate(R.layout.pm_fragment, container, false);


        listView = (ListView) rootView.findViewById(R.id.todoItems);
        items = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

        listView.setAdapter(adapter);


        Button button = (Button) rootView.findViewById(R.id.btnAddItem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) rootView.findViewById(R.id.todoEdit);
                String itemText = editText.getText().toString();
                adapter.add(itemText);
                editText.setText("");
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        setupListViewListener();

        return rootView;
    }

    private void setupListViewListener() {
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView<?> av,
                                                   View item, int pos, long id){
                        items.remove(pos);
                        adapter.notifyDataSetChanged();
                        return true;
                    }
                });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AddItem(View view) {
        EditText editText = (EditText) rootView.findViewById(R.id.todoEdit);
        String itemText = editText.getText().toString();
        adapter.add(itemText);
        editText.setText("");
    }
}