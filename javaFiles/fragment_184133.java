try (BufferedReader bufferedReader = new BufferedReader(reader)) {
        Block block = new Block();
        String line, previousIndents = "";
        while (null != (line = bufferedReader.readLine()) {
            Matcher m = Pattern.compile("^(\\s+)").matcher(line);
            if (m.find()) {
                String indents = m.group(1);
                if (previousIndents.equals(indents)) {
                     // update current block
                } else if (indents.length() > previousIndents.length()) {
                     // start a new block
                     Block newBlock = new Block();
                     newBlock.setParent(block);
                     block.getChildren().add(newBlock);

                     block = newBlock;
                } else {
                     // current block finished, return to parent
                     block = block.getParent();
                }

                previousIndents = indents;
            }
        } 
    }
    catch (IOException ioEx) {
        throw new ParseException(ioEx);
    }