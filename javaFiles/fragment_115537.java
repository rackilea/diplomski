// Modify the Guard class
package castle;

public class Guard {
    public IPrincess getPrincess() {
        return new Princess();
    }
    public static IPrincess getPrincessStatic() {
        return new Princess();
    }

    // for here i use Princess instead of IPrincess. (@midnite)
    private Princess m_princess = new Princess();
    public IPrincess getPrincessMember() {
        return m_princess;
    }
}