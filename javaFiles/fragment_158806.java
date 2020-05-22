public void unmarshalledDocumentHasExpectedValue() {
    doc = unmarshaller.unmarshal(getResourceAsStream("mydoc.xml"));

    expectedFailure.setExpectedFailure(doc.getVersionNumber() < 3000);

    final ST title = doc.getTitle();
    assertThat(doc.getTitle().toStringContent(), equalTo("Expected"));
}