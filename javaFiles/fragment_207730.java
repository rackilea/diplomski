try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        ImageIO.write(output, "png", baos);
        ret.setImageData(baos.toByteArray());
    } catch (IOException ex) {
        Logger.getLogger(ImageGenerationService.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }