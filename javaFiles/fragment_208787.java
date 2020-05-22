package cs4326.cook4me;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nathan1324 on 4/16/17.
 */

public class CompleteInstructionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public CompleteInstructionFragment() {
        // required empty constructor
    }

    //Recipe robj= getIntent().getParcelableExtra("recipe_object");

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public static CompleteInstructionFragment newInstance() {
        CompleteInstructionFragment fragment = new CompleteInstructionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        // view created from XML layout
        View view = inflater.inflate(R.layout.fragment_completeinstruction, container, false);

//        Create
//                View
//                        Here

        // could add other customization here for loyout components later
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}