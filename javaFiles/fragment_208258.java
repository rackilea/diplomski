try (Scanner scanner = new Scanner(path)) {
    scanner.findAll(pattern).forEach(matchResult ->
            System.out.println("Match: " + matchResult.group(1))
    );
} catch (IOException e) {
    e.printStackTrace();
}