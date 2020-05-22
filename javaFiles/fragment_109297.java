byte[] cache = null;
        try (FileInputStream in = new FileInputStream("C:\\Users\\JustAGod\\Projects\\gloomymods\\BuildTools\\BytecodeTools\\out\\production\\classes\\gloomyfolken\\Kek.class")) {
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassReader reader = new ClassReader(in);
            reader.accept(new YourClassVisitor(writer), ClassReader.EXPAND_FRAMES);
            cache = writer.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileOutputStream out = new FileOutputStream("C:\\Users\\JustAGod\\Projects\\gloomymods\\BuildTools\\BytecodeTools\\out\\production\\classes\\gloomyfolken\\Kek.class")) {
            out.write(cache);
        } catch (IOException e) {
            e.printStackTrace();
        }