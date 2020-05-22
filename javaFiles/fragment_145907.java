public class Employee {
    private String name;
    private String company;
    private int experience;

    public Employee(String name, String company, int experience) {
        this.name = name;
        this.company = company;
        this.experience = experience;
    }

    public Employee(String name, String company, String exp) {
        this.name = name;
        this.company = company;
        try {
            experience = Integer.parseInt(exp.trim());
        }
        catch(NumberFormatException utoh) {
            System.out.println("Failed to read experience for " + name + 
                    "\nCannot conver to integer: " + exp);
        }
    }

    public String toCSVString() {
       return name + "," + company + "," + experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}