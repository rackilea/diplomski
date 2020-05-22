this.resultDiv.setMarkupOutputId(true);

protected void onEvent( AjaxRequestTarget target ) {
      System.out.println( "Ajax!" );
      //resultDiv.setModel(  );
      resultDiv.setText("Foobar");
      resultDiv.renderComponent();
      target.add(resultDiv);
}