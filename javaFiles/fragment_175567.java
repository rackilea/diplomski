public void FiltarBusqueda(String filtro) {
    for (int r = 0; r < mTableLayout.getChildCount(); r++) {
        TableRow trow = (TableRow) mTableLayout.getChildAt(r);

        boolean hasMatch = false;

        for (int c = 0; c <= trow.getChildCount(); c++) {
            String text = ((TextView) trow.getChildAt(c)).getText().toString();

            hasMatch = text.equals(filtro); //when comparing Strings, use `equals()` not `==`
            if (hasMatch) break;
        }

        if (!hasMatch) {
            mTableLayout.removeRow(trow);
        }
    }
}