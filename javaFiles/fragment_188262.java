package dz.iaityahia.cieptalcars.matresorerie.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

public class CompteDialog extends TitleAreaDialog {

 private Text idCompteText;
 private Text libelleCompteText;
 private Text ribCompteText;
 private Text agenceCompteText;

public CompteDialog(Shell parentShell) {
    super(parentShell);
    setHelpAvailable(true);
    // TODO Auto-generated constructor stub
}

@Override
  public void create() {
    super.create();
    // Set the title
    setTitle("Fiche comptes");
    // Set the message
    setMessage("Saisissez les informations relatives au compte", 
        IMessageProvider.INFORMATION);
    setTitleImage(ResourceManager.getPluginImage("dz.iaityahia.cieptalcars.matresorerie", "icons/wallet.png"));


  }

@Override
 protected Control createDialogArea(Composite parent) {

    // cr�ation du Layout du la boite de dialog
    GridLayout parentLayout = new GridLayout();
    parentLayout.numColumns=1;
    parentLayout.marginWidth=0;
    parentLayout.marginHeight=0;
    parent.setLayout(parentLayout);

//Cr�ation du s�parateur sup�rieur  
 Label linetop = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
 linetop.setLayoutData(new GridData (SWT.FILL,SWT.TOP,true,false));

//Cr�ation du composite contenu     
Composite workArea = new Composite(parent, SWT.NONE);
workArea.setLayoutData(new GridData (SWT.FILL,SWT.FILL,true,true));





    GridLayout layout = new GridLayout();

    layout.numColumns = 2;
    layout.marginWidth=10;
    layout.marginHeight=10;
    workArea.setLayout(layout);





   // Champs ID 
   Label idCompteLabel = new Label(workArea,SWT.NONE);
   idCompteLabel.setText("Compte ID");

   idCompteText = new Text(workArea, SWT.BORDER);
   idCompteText.setLayoutData(new GridData(GridData.BEGINNING, GridData.BEGINNING, true,false,1, 1));
   idCompteText.setTextLimit(20);




   // Champs libelle
   Label libelleCompteLabel = new Label(workArea,SWT.NONE);
   libelleCompteLabel.setText("Libell� compte");

   libelleCompteText = new Text(workArea, SWT.BORDER);
   libelleCompteText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,false,1, 1));

   // Champs Rib
   Label ribCompteLabel = new Label(workArea,SWT.NONE);
   ribCompteLabel.setText("R.I.B");


   ribCompteText = new Text(workArea, SWT.BORDER);
   ribCompteText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,false, 1, 1));

   // Champs Agence bancaire
   Label agenceCompteLabel = new Label(workArea,SWT.NONE);
   agenceCompteLabel.setText("Agence bancaire");

   agenceCompteText = new Text(workArea, SWT.BORDER);
   agenceCompteText.setLayoutData( new GridData(GridData.FILL, GridData.BEGINNING, true,false, 1, 1));




    return parent; 
 }

 @Override
  protected Control createButtonBar(Composite parent) {

     Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
     line.setLayoutData(new GridData (SWT.FILL,SWT.TOP,true,false));


     final Composite buttonBar = new Composite(parent, SWT.NONE);
     buttonBar.setLayoutData(new GridData (SWT.FILL,SWT.TOP,true,false));

     final GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.makeColumnsEqualWidth = false;
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        buttonBar.setLayout(layout);



    // Create Add button
    // Own method as we need to overview the SelectionAdapter

    createOkButton(buttonBar, OK, "Add", true);
    // Add a SelectionListener

    // Create Cancel button
    Button cancelButton = 
        createButton(buttonBar, CANCEL, "Cancel", false);
    // Add a SelectionListener
    cancelButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        setReturnCode(CANCEL);
        close();
      }
    });
    return buttonBar;
  }