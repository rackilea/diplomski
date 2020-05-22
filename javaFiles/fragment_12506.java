package stackoverflow.test;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CompanyPanel extends AbstractJPanel implements CompanyFields {

    private static final long serialVersionUID = 7834845724312492112L;

    private JTextField companyNameField = null;
    private JTextField jobTitleField = null;
    private JTextField addressField = null;
    private JLabel companyNameLabel = null;
    private JLabel jobTitleLabel = null;
    private JLabel addressLabel = null;

    public CompanyPanel() {
        super();

        companyNameLabel = new JLabel("Company Name: ");
        jobTitleLabel = new JLabel("Job Title: ");
        addressLabel = new JLabel("Address: ");

        companyNameField = new JTextField();
        jobTitleField = new JTextField();
        addressField = new JTextField();

        super.add(companyNameLabel);
        super.add(companyNameField);
        super.add(jobTitleLabel);
        super.add(jobTitleField);
        super.add(addressLabel);
        super.add(addressField);
    }

    @Override
    public void setCompanyName(String companyName) {
        companyNameField.setText(companyName);
    }

    @Override
    public void setJobTitle(String jobTitle) {
        jobTitleField.setText(jobTitle);
    }

    @Override
    public void setAddress(String address) {
        addressField.setText(address);
    }

    @Override
    public String getCompanyName() {
        return companyNameField.getText();
    }

    @Override
    public String getJobTitle() {
        return jobTitleField.getText();
    }

    @Override
    public String getAddress() {
        return addressField.getText();
    }

}