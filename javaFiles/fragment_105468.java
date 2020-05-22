for(WordCategories.Noun n: nouns) {
  if(n instanceof WordCategories.Person) {
      // cast to WordCategories.Person and perform whatever action you like
      WordCategoriesPerson actualPerson = (WordCategories.Person) n;
  }
}