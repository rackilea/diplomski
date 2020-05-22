if (opSign == LT && comparedWith <= rangeMin) return alwaysFalse(instruction, runner, memState);
if (opSign == LT && comparedWith > rangeMax) return alwaysTrue(instruction, runner, memState);
if (opSign == LE && comparedWith >= rangeMax) return alwaysTrue(instruction, runner, memState);
if (opSign == LE && comparedWith < rangeMin) return alwaysFalse(instruction, runner, memState);

if (opSign == GT && comparedWith >= rangeMax) return alwaysFalse(instruction, runner, memState);
if (opSign == GT && comparedWith < rangeMin) return alwaysTrue(instruction, runner, memState);
if (opSign == GE && comparedWith <= rangeMin) return alwaysTrue(instruction, runner, memState);
if (opSign == GE && comparedWith > rangeMax) return alwaysFalse(instruction, runner, memState);