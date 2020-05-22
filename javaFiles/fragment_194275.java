import java.util.logging.Logger;

...

  private static final Logger LOGGER = Logger.getLogger(FileInput.class.getName());

...

  LOGGER.severe("Tried to create a FileInput from a non-existant/unreadable file " + fileName);