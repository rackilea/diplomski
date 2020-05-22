<installation version="1.0">
      <!-- Ant properties in this file can be referenced with @{},
           otherwise use variables below in installer files with ${} -->
      <info>
        <appname>@{product.name}</appname>
        <appversion>@{product.version}</appversion>
        <uninstaller name="remove.task" path="${INSTALL_PATH}/Uninstall" write="yes"/>
      </info>
...