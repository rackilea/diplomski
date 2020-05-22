try {
        String orderID = get();

        // Update some GUI elements using the orderID

    } catch(ExecutionException e) {
        Throwable cause = e.getCause( );
        if ( cause instanceof PlaceOrderException )
        {
            JOptionPane.showMessageDialog(
              this,
              "Please review your order",
              cause.getMessage(),
              JOptionPane.ERROR_MESSAGE,
              null
            );
        }
        else
        {
          LOGGER.error("Error placing order", e);
        }
    } catch (Exception e) {
        LOGGER.error("Error placing order", e);
    }