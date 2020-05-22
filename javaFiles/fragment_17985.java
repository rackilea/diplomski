catch (Exception e)
    {
        statusTextArea.append("Failed to disconnect from server. " + "\n".concat(e.getMessage()));
return false;
    }
}