@Override
protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);
    MainActivity.informations = this.dataParsed;
    // defensively copy
    MainActivity.persons = new ArrayList<>(this.persons);
}