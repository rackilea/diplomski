@Override
public void updateParameter(List param1, List param2) {

  List<String> param1TypeSafe = (List<String>)param1;
  List<String> param2TypeSafe = (List<String>)param2;
  updateParam1( param1TypeSafe );
  updateParam2( param2TypeSafe );
  //now nowhere else in the codebase needs to deal with it.
}