@Override
public void onClick(View v){
    switch (v.getId()) {
        case R.id.singup_withgoogle:  // ;=>:
            startActivity(new Intent(getActivity(), GoogleSignInActivity.class)); //); => ));
            break;
    }
}