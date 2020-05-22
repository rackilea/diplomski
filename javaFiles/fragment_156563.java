try (DataInputStream inputStream =
        new DataInputStream(
        new BufferedInputStream(
        new ByteArrayInputStream(this.byteOut.toByteArray())))) {
        while (true)
            intStreamBuilder.accept(inputStream.readInt());
    } catch (EOFException e) {
        int[] pool = intStreamBuilder.build().toArray();
        super.lock(pool);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }