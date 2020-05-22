package com.example.boc.search;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.boc.Interface.IMainActivity;
import com.example.boc.R;
import com.example.boc.main.phone_nombers_Activity;
import com.example.boc.models.Note;
import com.example.boc.models.Search;
import com.google.android.gms.tasks.OnCompleteListener;

import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class searchActivity extends phone_nombers_Activity implements
        View.OnClickListener,
        IMainActivity
{

    private DocumentSnapshot documentSnapshot;
    ListView listView;
    public TextView resultTxt , userinput ;
    private ArrayList<Search> mSearch = new ArrayList<>();


    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    public Note note ;
    public LinearLayout layout ;

    private ArrayList<Note> mNotes = new ArrayList<>();

    private DocumentReference noteRef = db.collection("notes").document();
    private CollectionReference notesCollectionRef = db.collection("notes");
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_search );
        final ListView listView = findViewById( R.id.listview4 );
        final EditText userinput = findViewById( R.id.userInputtxt );
        final Button   findbutton = findViewById( R.id.findBtn );
        final TextView resultTxt = findViewById( R.id.resultTxt );
        mRecyclerView = findViewById(R.id.recycler_view);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        CollectionReference notesCollectionRef = db
                .collection("notes");

        Query notesQuery = null;
        if(documentSnapshot != null){
            notesQuery = notesCollectionRef;

        }
        else{
            notesQuery = notesCollectionRef
                    .orderBy("timestamp", Query.Direction.ASCENDING);
        }


        notesQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    String data = "";

                    for(final QueryDocumentSnapshot document: task.getResult()){
                        Note note = document.toObject(Note.class);

                        mNotes.add(note);
                        if( userinput !=null ) {
                            findbutton.setOnClickListener( new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    final String userinputString = userinput.getText().toString();

                                    ArrayList<String> namesList = new ArrayList<>();
                                    for (Note note : mNotes) {
                                        if (note.getTitle().contains(userinputString)) {
                                            String matchedtitle = note.getTitle();
                                            String matchedcontent = note.getContent();
                                            String matcheddata += "هاتف:" + matchedcontent + "\nالاسم:" + matchedtitle + "\n\n";
                                            namesList.add(matcheddata);
                                    }

                                    ArrayAdapter<String> adapter = new ArrayAdapter<>( getApplicationContext(), android.R.layout.simple_selectable_list_item, namesList );
                                    listView.setAdapter(adapter);
                                }

                            } );
                        }
                        else {
                            userinput.setError( "اسم الملف مطلوب" );
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onStart () {

        super.onStart();

    }
}