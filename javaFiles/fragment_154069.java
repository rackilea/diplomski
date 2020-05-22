public class LogViewer{
 Text mainText;
 Text detailText;
 public void initialize(Composite parent){
  parent.setLayout(new FillLayout(SWT.VERTICAL));
  SashForm sashForm =new SashForm(parent, SWT.VERTICAL);
  mainText = new Text( sashForm , SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL );
  detailText = new Text( sashForm , SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL );
  mainText.setVisible( true );
  detailText.setVisible( true );
  sashForm.setWeights(new int[]{1,3});
  mainText.setText("This is the error message");
  detailText.setText("This text is mulitline error text message")
 }
}