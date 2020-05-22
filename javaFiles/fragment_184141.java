public class SubWordFinderTest {

    @Test
    public void generalTest() throws SubWordFinder.NoSolutionFoundException {
        List<String> words = new ArrayList<String>();
        words.add("ab");
        words.add("abc");
        words.add("cd");
        words.add("cde");
        words.add("de");
        words.add("e");
        SubWordFinder finder = new SubWordFinder(words);
        assertEquals(new ArrayList<String>(), finder.findSubWords(""));
        assertEquals(Arrays.asList("ab", "cde"), finder.findSubWords("abcde"));
        assertEquals(Arrays.asList("cd", "cde"), finder.findSubWords("cdcde"));
        assertEquals(Arrays.asList("abc", "cd"), finder.findSubWords("abccd"));
        assertEquals(Arrays.asList("de", "e", "e", "e", "e"), finder.findSubWords("deeeee"));
        try {
            finder.findSubWords("ae");
            fail();
        } catch (SubWordFinder.NoSolutionFoundException e) {
        }
        try {
            finder.findSubWords("abcccd");
            fail();
        } catch (SubWordFinder.NoSolutionFoundException e) {
        }
        try {
            finder.findSubWords("abcdex");
            fail();
        } catch (SubWordFinder.NoSolutionFoundException e) {
        }
    }

    @Test
    public void dictionaryTest() throws IOException, SubWordFinder.NoSolutionFoundException {
        String resourceDir = "/path_to_resources";
        InputStream inputStream = getClass().getResource(resourceDir + "/20k.txt").openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<String> words = new ArrayList<String>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            words.add(line);
        }
        SubWordFinder finder = new SubWordFinder(words);
        assertEquals(Arrays.asList("bromide", "freshet"), finder.findSubWords("bromidefreshet"));
    }

}