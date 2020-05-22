public class CustomLineMapper extends DefaultLineMapper<Claim> {

    @Override
    public Claim mapLine(String line, int lineNumber) throws Exception {
        // here you can handle *line content*
        return super.mapLine(line, lineNumber);
    }
}