AlertDialog.Builder pinAuth = new AlertDialog.Builder(this);
LayoutInflater inflater = LayoutInflater.from(this);
View view = inflater.inflate(R.layout.dialog_pin, null);

pinAuth.setTitle("PIN required.");
pinAuth.setCancelable(false);
pinAuth.setView(view);

final EditText pin = (EditText) view.findViewById(R.id.whateverThisEditTextIdIs);
pin.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);