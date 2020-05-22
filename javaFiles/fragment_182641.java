NotesDocument document = ...;

...

// Even you called document.remove(), it still exists because the code does not destroy the object and reference itself.

document.remove(true);

// That is why this still works.
if (document != null) {
    System.out.println(document.getItemValueString("ID"));
}