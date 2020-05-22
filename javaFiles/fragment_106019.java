Map<Character, String> encryptionMappings = new HashMap<>();
encryptionMappings.put('H', "{aeh}");
encryptionMappings.put('e', "{wer}");
... and so on: one put() for all characters you wish to support
Map<String, Character> decryptionMappings = new HashMap<>();
decryptionMappings.put("{aeh}", 'H');
... as above, just "reversed"