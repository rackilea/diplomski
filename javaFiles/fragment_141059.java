try {
        if (newUserPassword.equals(confirmedPassword)) {
            Path filePath = Paths.get("./file.csv");
            if (Files.notExists(filePath)) {
                filePath.toFile().createNewFile();
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(newUsername);
            stringBuilder.append(',');
            stringBuilder.append(newUserPassword);
            stringBuilder.append(System.lineSeparator());

            Files.write(filePath, stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
        } else {
            System.out.println("Password are not matched");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }