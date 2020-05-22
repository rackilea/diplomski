try{
        ServerErrorMessage serverErrorMessage = gson.fromJson(
            result, ServerErrorMessage.class);
    }catch (JsonSyntaxException e){
        // handle the exception
    }
    catch (JsonIOException e){
        // handle the exception
    }
    catch (JsonParseException e){
        // handle the exception
    }catch (IOException e){
        // handle the exception
    }